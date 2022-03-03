package C_封装多态继承_面试.a_Association_of_Classes;

import java.util.ArrayList;

/**
 * 类之间的关系： Association > Aggregation > Composition
 *  Aggregation(车店 和 车的关系): 车店里有车，但车店 暂时没车也可以，属于“has-a”的关系，非强关联
 *  Composition(车 和 引擎的关系): 车由引擎组成，车不可以没有引擎，“part-of”的关系，属于一种“强关联”的Aggregation
 * */
public class CarShop {
    ArrayList<Vehicle> arr;
}

class Vehicle {
    String vehicleBrand;
    Engine engine;
}

class Engine {
    String brand;
    int size;
}