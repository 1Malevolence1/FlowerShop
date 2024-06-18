package com.example.businesslogic.controler.flower;


public abstract class ControllerHelper<T, E, Z, ID> implements ControllerHelperImpl<T, E, Z, ID> {


    @Override
    public void updateEntityReturnVoid(E payload, ID id) {
        printErrorText();
    }

    @Override
    public Z createEntity(T newEntity) {
        printErrorText();
        return null;
    }

    @Override
    public void createEntityReturnVoid(T newEntity) {
        printErrorText();
    }

    private void printErrorText(){
        throw new RuntimeException("Ты забыл переопределить меня");
    }
}
