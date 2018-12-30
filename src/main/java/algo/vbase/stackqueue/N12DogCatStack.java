package algo.vbase.stackqueue;

import java.util.ArrayDeque;
import java.util.Date;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/6/29 9:42
 * @desc   :
 */
public class N12DogCatStack {

    public static ArrayDeque<Dog> dogs = new ArrayDeque<>();
    public static ArrayDeque<Cat> cats = new ArrayDeque<>();

    public static void main(String[] args) throws InterruptedException {

        Dog dog1 = new Dog();
        Thread.sleep(1000);
        Cat cat1 = new Cat();
        Thread.sleep(1000);
        Cat cat2 = new Cat();
        Thread.sleep(1000);
        Dog dog2 = new Dog();
        Thread.sleep(1000);
        Dog dog3 = new Dog();
        Thread.sleep(1000);
        Cat cat3 = new Cat();

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3); // dog cat cat dog dog cat

//        pollDog();
//        pollDog();
//        pollDog();


        pollAll();

        return;
    }

    public static void pollDog(){
        if(dogs.isEmpty()) {
            System.out.println("dog's empty");
            return;
        }
        Dog firstDog = dogs.poll();
        System.out.println("pollDog: " + firstDog.toString());
    }

    public static void pollCat(){
        if(cats.isEmpty()) {
            System.out.println("cat's empty");
            return;
        }
        Cat firstCat = cats.poll();
        System.out.println("pollCat: " + firstCat.toString());
    }

    public static void pollOne(){
        if(dogs.isEmpty()){
            pollCat();
        }else if(cats.isEmpty()){
            pollDog();
        }else{
            Dog firstDog = dogs.getFirst();
            Cat firstCat = cats.getFirst();
            if (firstDog.getTime() < firstCat.getTime()) { //dog earlier than cat
                pollDog();
            } else {
                pollCat();
            }
        }
    }

    public static void pollAll(){
        while(!isEmpty()){
            pollOne();
        }
    }

    public static boolean isDogEmpty(){
        return dogs.isEmpty();
    }

    public static boolean isCatEmpty(){
        return cats.isEmpty();
    }

    public static boolean isEmpty(){
        return isDogEmpty() && isCatEmpty();
    }



}
class Pet{
        private String type;
//        private Date time;
        private long time;
        public Pet(String type) {
            this.type = type;
            this.time = new Date().getTime();
        }
        public String getType() { return type; }
        public long getTime() { return time; }
    }

    class Dog extends Pet{
        public Dog() {
            super("Dog");
        }

        @Override
        public String toString() {
            return "Dog: " + this.getType() + this.getTime();
        }
    }

    class Cat extends Pet{
        public Cat() { super("Cat"); }
        @Override
        public String toString() {
            return "Cat: " + this.getType() + this.getTime();
        }
    }
