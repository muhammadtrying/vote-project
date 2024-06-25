package uz.muhammadtrying.voteproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private String name;
    private String phone;
    private Integer bloggerId;
}
