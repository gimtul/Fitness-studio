public class FactorySession {
    public static Session createSession(SessionType sessionType){
        switch (sessionType) {
            case MachinePilates:
                return new MachinePilates();
            case Pilates:
                return new Pilates();
            case Ninja:
                return new Ninja();
            case ThaiBoxing:
                return new ThaiBoxing();
            default:
                throw new IllegalArgumentException("error: session type does not exist");
        }
    }
}
