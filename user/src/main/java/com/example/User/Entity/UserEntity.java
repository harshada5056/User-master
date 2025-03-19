package com.example.User.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Schema(description = "User", name = "User")
public class UserEntity {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(name = "userId",example ="1",required = true)
    private Long userId;
    @Schema(name = "name",example ="John",required = true)
    private String name;
    @Schema(name = "address",example ="New York",required = true)
    private String address;
    @Schema(name = "itemId",example ="1",required = true)
    private Long itemId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
