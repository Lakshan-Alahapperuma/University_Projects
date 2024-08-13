/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package attendance;

public abstract class pro1 {

    public abstract void thank();

    public void thank1() {

        System.out.println("Come Again..!\n");

    }

}

class pro2 extends pro1 {

    @Override
    public void thank() {

        System.out.println("Thank You..!\n");

    }

}
