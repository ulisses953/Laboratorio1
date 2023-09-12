package model;

import java.util.ArrayList;

public class Cinema {
    private long id;
    private String name;
    private ArrayList<User> usuarios = new ArrayList<User>();
    private ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
}
