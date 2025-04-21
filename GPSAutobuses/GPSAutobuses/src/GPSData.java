public class GPSData {
    private String busId;   // Identificador del autobus
    private String timestamp; // En formato ISO 8601
    private double latitude;     // Latitud geográfica del autobus
    private double longitude;    // Altitud geográfica del autobus
    private double speed;   // Velocidad del autobus en km/h

    public GPSData(String busId, String timestamp, double latitude, double longitude, double speed) {
        this.busId = busId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
    }

    public String getBusID() {
        return busId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return busId + "," + timestamp + "," + latitude + "," + longitude + "," + speed;
    }
}
