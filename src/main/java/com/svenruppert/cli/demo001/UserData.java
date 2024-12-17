package com.svenruppert.cli.demo001;

import java.io.Serializable;

public class UserData implements Serializable {
  private static final long serialVersionUID = 1L;
  String username;

  public UserData(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "Username: " + username;
  }
}