package task.job.restApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.job.restApi.model.Rating;
import task.job.restApi.model.Znamenitost;
import task.job.restApi.repository.RatingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatingsForZnamenitost(long znamenitostId) {
        List<Rating> allRatings= ratingRepository.findAll();
        List<Rating> znamenitostRatings=new ArrayList<>();
        for(int i=0;i<allRatings.size();i++){
            if(allRatings.get(i).getZnamenitostId()==znamenitostId){
                znamenitostRatings.add(allRatings.get(i));
            }
        }
        return znamenitostRatings;
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    @Override
    public Rating updateRatingForZnamenitost(long ratingId) {
        return null;
    }

    @Override
    public Rating rateZnamenitost(Rating ocjena) {
        return this.ratingRepository.save(ocjena);
    }

    @Override
    public void deleteRating(long ratingId) {

    }

    @Override
    public void deleteZnamenitostRatings(long znamenitostId) {

    }
}
