package org.proxy.java;

public class SayA implements Say {

  @Override
  public void say() {
    System.out.println("A is saying");
  }

  @Override
  public String sayWords() {
    return "A";
  }

}
