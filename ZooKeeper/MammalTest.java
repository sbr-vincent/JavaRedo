class MammalTest {
    public static void main(String[] args) {
        System.out.println("Ooo ooo aa oo");
        Mammal animal = new Mammal();

        animal.setEnergy(100);

        Gorilla gorilla = new Gorilla();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();

        gorilla.eatBananas();
        gorilla.eatBananas();

        System.out.println("This is the total energy:" + gorilla.displayEnergy());
    }
}