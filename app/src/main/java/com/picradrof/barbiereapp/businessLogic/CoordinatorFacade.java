package com.picradrof.barbiereapp.businessLogic;

public class CoordinatorFacade implements ICliente {

    //**************** Singleton ******************/
    private static CoordinatorFacade instance = null;

    private CoordinatorFacade() {}

    public static CoordinatorFacade getInstance() {
        return instance;
    }
    //********************************************/

    @Override
    public boolean effettuaRegistrazione(String username, String password, String nome, String cognome) {
        CoordinatorCliente corCliente = CoordinatorCliente.getInstance();
        return corCliente.effettuaRegistrazione(username, password, nome, cognome);
    }

    @Override
    public boolean login(String username, String password) {
        CoordinatorCliente corCliente = CoordinatorCliente.getInstance();
        return corCliente.login(username, password);
    }
}
