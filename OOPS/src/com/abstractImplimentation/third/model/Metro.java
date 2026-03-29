class Metro extends Transport {

    private int stations;

    public Metro(String routeId, double baseFare, int stations) {
        super(routeId, baseFare);
        this.stations = stations;

        System.out.println("Metro constructor executed");
    }

    public double calculateFare() {

        double fare = baseFare + (stations * 5);
        return fare;
    }
}