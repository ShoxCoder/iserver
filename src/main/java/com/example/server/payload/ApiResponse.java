package com.example.server.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@PackagePrivate
public class ApiResponse {
   String message;
   boolean success;
   Object object;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message) {
        this.message = message;
    }


}
