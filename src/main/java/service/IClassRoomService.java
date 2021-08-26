package service;


import model.ClassRoom;

import java.util.ArrayList;

public interface IClassRoomService {
    ArrayList<ClassRoom> findAll();
    ClassRoom findById(long id);
}