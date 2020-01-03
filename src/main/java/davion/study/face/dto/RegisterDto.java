package davion.study.face.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Davion
 * @date: 2020/1/3
 * @description:
 */
@NoArgsConstructor
@Data
public class RegisterDto {

    /**
     * error_code : 0
     * error_msg : SUCCESS
     * log_id : 1010010010589
     * timestamp : 1578027042
     * cached : 0
     * result : {"face_token":"fbce4b2c6f7f6a968047173fca857bae","location":{"left":132.95,"top":251.27,"width":222,"height":217,"rotation":1}}
     */

    private int error_code;
    private String error_msg;
    private long log_id;
    private int timestamp;
    private int cached;
    private ResultBean result;

    @NoArgsConstructor
    @Data
    public static class ResultBean {
        /**
         * face_token : fbce4b2c6f7f6a968047173fca857bae
         * location : {"left":132.95,"top":251.27,"width":222,"height":217,"rotation":1}
         */

        private String face_token;
        private LocationBean location;

        @NoArgsConstructor
        @Data
        public static class LocationBean {
            /**
             * left : 132.95
             * top : 251.27
             * width : 222
             * height : 217
             * rotation : 1
             */

            private double left;
            private double top;
            private int width;
            private int height;
            private int rotation;
        }
    }
}
