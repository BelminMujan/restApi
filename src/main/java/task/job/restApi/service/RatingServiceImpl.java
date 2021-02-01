package task.job.restApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.job.restApi.exceptions.ResourceNotFoundException;
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
    public Rating updateRating(Rating rating) {
        Optional<Rating> ratingDb=this.ratingRepository.findById(rating.getId());
        if (ratingDb.isPresent()){
            Rating ratingUpdate=ratingDb.get();
            ratingUpdate.setId(rating.getId());
            ratingUpdate.setOcjena(rating.getOcjena());
            ratingUpdate.setZnamenitostId(rating.getZnamenitostId());
            return ratingUpdate;
        }else{
            throw new ResourceNotFoundException("NIje pronadjena znamenitost sa id :"+rating.getId());
        }
    }

    @Override
    public Rating rateZnamenitost(Rating ocjena) {
        return this.ratingRepository.save(ocjena);
    }

    @Override
    public void deleteRating(long ratingId) {
        Optional<Rating> ratingDb= this.ratingRepository.findById(ratingId);
        if(ratingDb.isPresent()){
            this.ratingRepository.delete(ratingDb.get());
        }else{
            throw new ResourceNotFoundException("Nije pronadjen rating sa id: "+ ratingId);
        }
    }

    @Override
    public void deleteZnamenitostRatings(long znamenitostId) {

    }
}
