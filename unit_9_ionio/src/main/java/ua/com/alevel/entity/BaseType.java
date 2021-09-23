package ua.com.alevel.entity;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseType {
     private static int id = 0;

     public int  getId() {
          return id;
     }

     public void setId() {
          id++;
     }
}
