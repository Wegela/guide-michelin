package michelin.polytech.guidemichelin.dto;


import lombok.Data;

@Data
public class ErrorMessageDto {
    public String code;
    public String message;

    public ErrorMessageDto(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }


}
