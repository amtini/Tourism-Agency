package backend.Functions;

public class DifficultyFunction {
    public static String calculateDifficulty(Integer low, Integer mid, Integer high){
        if(high > mid && high > low){ 
            return "HIGH";
        }else if(mid > high && mid > low){
            return "MID";
        }else if(low > high && low > mid){
            return "LOW";
        }else if(high == mid && mid > low){
            return "HIGH";
        }else if(mid == low && low > high){
            return "MID";
        }else if(high == low && low > mid){
            return "HIGH";
        }else {
            return "HIGH";
        }
    }
}


/*
- Calculate Difficulty of Itinerary / Uses difficulty of the activities of each day inside the days list of Itirenary
  The max amount of same difficulties in the day should be the difficulty of the day, but if there is more difficulties on the same amount,
  we should choose the higher difficulty. Same process with itinerary difficulty, but now we check the day difficulty.
*/