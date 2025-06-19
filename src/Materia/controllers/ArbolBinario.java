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
            imprimir(node.getLeft());
            
            System.out.print(node.getValue() +" ");
            
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
    public int getHeight(){
        return getHeightRec(root);
    }
    private int getHeightRec(Node node) {
    if (node == null) {
        return 0;
    }
    int leftHeight = getHeightRec(node.getLeft());
    int rightHeight = getHeightRec(node.getRight());
    return Math.max(leftHeight, rightHeight) + 1;
}


    public int buscarAltura(int value) {
        return buscarAlturaRec(root,value, 0);
    }
    public int buscarAlturaRec(Node node, int value, int altura){
        if (node == null) {
            return -1; // Valor no encontrado
        }
        if (node.getValue() == value) {
            return altura;
        }
        if (value < node.getValue()) {
            return buscarAlturaRec(node.getLeft(), value, altura + 1);
        } else {
            return buscarAlturaRec(node.getRight(), value, altura + 1);
        }
        
    }
    public void buscarAlturaN(){
        buscarAlturaRes(root);

    }
    public void buscarAlturaRes(Node node){
        if (node != null){
            imprimir(node.getLeft());
            int height = getHeightRec(node);
            System.out.println("["+height+"]");
            imprimir(node.getRight());
        }

    }
    public int calcularPeso() {
        return calcularPesoRec(root);
    }
    private int calcularPesoRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + calcularPesoRec(node.getLeft()) + calcularPesoRec(node.getRight());
    }

    public void imprimirInOrderConAlturas() {
    imprimirAlturas(root);
    System.out.println();
    }

    private void imprimirAlturas(Node node) {
        if (node != null) {
            imprimirAlturas(node.getLeft());
            int altura = getHeightRec(node); 
            System.out.print(node.getValue() + "(h=" + (altura) + "), ");
            imprimirAlturas(node.getRight());
        }
    }

    public void imprimirInOrderConFactorEquilibrio() {
        imprimirFactorEquilibrio(root);
        System.out.println();
    }

    private void imprimirFactorEquilibrio(Node node) {
        if (node != null) {
            imprimirFactorEquilibrio(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            System.out.print(node.getValue() + "(bf=" + bf + "), ");
            imprimirFactorEquilibrio(node.getRight());
        }
    }

    public boolean estaEquilibrado() {
    return verificarBalance(root);
    }

    private boolean verificarBalance(Node node) {
        if (node == null) return true;

        int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
        if (Math.abs(bf) > 1) return false;

        return verificarBalance(node.getLeft()) && verificarBalance(node.getRight());
    }

    public void mostrarNodosDesequilibrados() {
    System.out.print("Nodos desequilibrados = ");
    listarDesequilibrados(root);
    System.out.println();
}

private void listarDesequilibrados(Node node) {
    if (node != null) {
        listarDesequilibrados(node.getLeft());
        int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
        if (Math.abs(bf) > 1) {
            System.out.print(node.getValue() + "(fE = " + bf + ") ");
        }
        listarDesequilibrados(node.getRight());
    }
}



}
