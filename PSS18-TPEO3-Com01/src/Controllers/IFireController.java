package Controllers;


import Map.Map;

public abstract class IFireController implements IController {



    public IFireController(){
        Map.getInstance().add(this);
    }




}
