package davion.study.face.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Davion
 * @date: 2020/1/3
 * @description:
 */
@NoArgsConstructor
@Data
public class SearchDto {

    /**
     * error_code : 0
     * error_msg : SUCCESS
     * log_id : 8989101797579
     * timestamp : 1578031392
     * cached : 0
     * result : {"face_token":"cfaf131633fa97d206e065e59c9a5d92","user_list":[{"group_id":"davion","user_id":"liuyong","user_info":"","score":97.732391357422}]}
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
         * face_token : cfaf131633fa97d206e065e59c9a5d92
         * user_list : [{"group_id":"davion","user_id":"liuyong","user_info":"","score":97.732391357422}]
         */

        private String face_token;
        private List<UserListBean> user_list;

        @NoArgsConstructor
        @Data
        public static class UserListBean {
            /**
             * group_id : davion
             * user_id : liuyong
             * user_info :
             * score : 97.732391357422
             */

            private String group_id;
            private String user_id;
            private String user_info;
            private double score;
        }
    }
}
