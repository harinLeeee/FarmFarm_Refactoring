package com.example.farmfarm_refact.entity.oauth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoProfile {
    public Long id;
    public String connected_at;
    public Properties properties;
    public KakaoAccount kakao_account;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Properties { //(1)
        public String nickname;
        public String profile_image; // 이미지 경로 필드1
        public String thumbnail_image;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class KakaoAccount { //(2)
        public Boolean profile_nickname_needs_agreement;
        public Boolean profile_image_needs_agreement;
        public Profile profile;
        public Boolean has_email;
        public Boolean email_needs_agreement;
        public Boolean is_email_valid;
        public Boolean is_email_verified;
        public String email;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Profile {
            public String nickname;
            public String thumbnail_image_url;
            public String profile_image_url; // 이미지 경로 필드2
            public Boolean is_default_image;
            public Boolean is_default_nickname;
        }
    }
}