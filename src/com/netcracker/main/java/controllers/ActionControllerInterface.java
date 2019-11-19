package controllers;

import models.ActionModel;

public interface ActionControllerInterface {
    void create(ActionModel actionModel);
    void delete(ActionModel actionModel);
    void show(ActionModel actionModel);
    void save(ActionModel actionModel);
    void exit(ActionModel actionModel);
}

