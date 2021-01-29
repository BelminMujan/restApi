package task.job.restApi.service;

import task.job.restApi.model.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getRatingsForZnamenitost(long znamenitostId);
    List<Rating> getAllRatings();
    Rating updateRatingForZnamenitost(long ratingId);
    Rating rateZnamenitost(Rating ocjena);
    void deleteRating(long ratingId);
    void deleteZnamenitostRatings(long znamenitostId);
}
