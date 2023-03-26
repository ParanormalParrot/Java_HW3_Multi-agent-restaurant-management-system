import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class PrepareDish extends Behaviour {

    @Override
    public void action() {
        if (!ManagerAgent.orders.isEmpty()) {
            Order order = ManagerAgent.orders.peek();
            for (MenuItem menuItem : Controller.menu.getMenu()) {
                if (menuItem.getId() == order.getDishId()) {
                    for (Recipe recipe : Controller.recipes.getRecipes()) {
                        if (recipe.getId() == menuItem.getRecipeId()) {
                            for (Operation operation : recipe.getProcess().getOperations()) {
                                for (Equipment equipment : Controller.equipment.getEquipment()) {
                                    if (equipment.getEquipmentType_id() == operation.getEquipType()) {
                                        equipment.setActive(false);
                                        myAgent.doWait((long) (operation.getTime()*1000));
                                        JsonManager.writeLog(new JsonAction(
                                                "Action",
                                                myAgent.getLocalName(),
                                                getClass().getName(),
                                                operation.toString(),
                                                myAgent.getLocalName() + " performed operation"));
                                        equipment.setActive(true);
                                        ManagerAgent.orders.poll();
                                        break;
                                    }
                                }
                            }
                            JsonManager.writeLog(new JsonAction(
                                    "Action",
                                    myAgent.getLocalName(),
                                    getClass().getName(),
                                    "",
                                    myAgent.getLocalName() + " prepared " + recipe.getName()));
                            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                            msg.addReceiver(new AID("Order" + ManagerAgent.map.get(order.getId()), AID.ISLOCALNAME));
                            try {
                                var message = new Message(myAgent.getLocalName(), "ready");
                                msg.setContentObject(message);
                                myAgent.send(msg);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
