import java.util.ArrayList;
import java.util.List;

interface HangarInterface<T> {
    void addPlane(T plane);
    T removePlane();
    T getCurrentPlane();
    boolean isEmpty();
    boolean isFull();
    void clearHangar();
    String getHangarStatus();
}

class Hangar<T> implements HangarInterface<T> {
    private List<T> planes;
    private int capacity;

    public Hangar(int capacity) {
        this.capacity = capacity;
        this.planes = new ArrayList<>();
    }

    @Override
    public void addPlane(T plane) {
        if (!isFull()) {
            planes.add(plane);
            System.out.println(plane + " added to the hangar.");
        } else {
            System.out.println("Hangar is full. Cannot add more planes.");
        }
    }

    @Override
    public T removePlane() {
        if (!isEmpty()) {
            T plane = planes.remove(planes.size() - 1);
            System.out.println(plane + " removed from the hangar.");
            return plane;
        } else {
            System.out.println("Hangar is empty. No planes to remove.");
            return null;
        }
    }

    @Override
    public T getCurrentPlane() {
        if (!isEmpty()) {
            return planes.get(planes.size() - 1);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return planes.isEmpty();
    }

    @Override
    public boolean isFull() {
        return planes.size() >= capacity;
    }

    @Override
    public void clearHangar() {
        planes.clear();
    }

    @Override
    public String getHangarStatus() {
        return "Hangar capacity: " + capacity + ", Current number of planes: " + planes.size();
    }
}

class Plane {
    private String model;
    private String type;

    public Plane(String model, String type) {
        this.model = model;
        this.type = type;
    }

    @Override
    public String toString() {
        return model + " (" + type + ")";
    }
}

public class HangerTest {
    public static void main(String[] args) {
        Hangar<Plane> hangar = new Hangar<>(5);

        hangar.removePlane();

        Plane cessna = new Plane("Cessna 172", "Light Aircraft");
        Plane boeing737 = new Plane("Boeing 737", "Commercial Jet");

        hangar.addPlane(cessna);
        hangar.addPlane(boeing737);

        System.out.println(hangar.getHangarStatus());
        hangar.removePlane();
        System.out.println(hangar.getHangarStatus());
        hangar.removePlane();

        hangar.addPlane(new Plane("Airbus A320", "Commercial Jet"));
        hangar.addPlane(new Plane("Boeing 747", "Commercial Jet"));
        hangar.addPlane(new Plane("Embraer 190", "Regional Jet"));
        hangar.addPlane(new Plane("Bombardier CRJ200", "Regional Jet"));
        hangar.addPlane(new Plane("Cessna 208 Caravan", "Light Aircraft"));
        hangar.addPlane(new Plane("Piper Navajo", "Light Aircraft"));
    }
}
