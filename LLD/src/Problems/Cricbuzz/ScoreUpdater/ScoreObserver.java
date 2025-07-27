package Problems.Cricbuzz.ScoreUpdater;

import Problems.Cricbuzz.BallDetails;

public interface ScoreObserver {
    public void update(BallDetails ballDetails);
}
