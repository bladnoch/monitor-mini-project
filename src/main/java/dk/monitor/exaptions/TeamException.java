package dk.monitor.exaptions;

/**
 * 이미 존재하는 팀일 경우 throw exception
 */
public class TeamException extends RuntimeException{
    public TeamException(String message) {
        super(message);
    }
}
