package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }
    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }
    public void imprimirArbol() {
        imprimir(root);
    }
    private void imprimir(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            imprimir(node.getLeft());
            imprimir(node.getRight());
            
        }
    }   

    public void buscarArbol(int value){
        boolean encontrado = buscar(root, value);
        if (encontrado){
            System.out.println("Encontrado");
        }
        else{
            System.out.println("No encontrado");
        }
    }


    public boolean buscar(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        if (value < node.getValue()) {
            return buscar(node.getLeft(), value);
        } else {
            return buscar(node.getRight(), value);
        }
    }
}
