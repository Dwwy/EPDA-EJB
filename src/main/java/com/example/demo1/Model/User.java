package com.example.demo1.Model;

import com.example.demo1.Util.StaticVariable;
import com.example.demo1.Util.TextEncryptor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    @Column(unique=true)
    private String email;
    private LocalDateTime creationDate = LocalDateTime.now();
    private StaticVariable.accountType accountType;
    private String password;
    public String getPassword(){
        TextEncryptor encryptor = new TextEncryptor(StaticVariable.authenticator_secret());
        return encryptor.decrypt(this.password);
    }
    public void setPassword(String text){
        TextEncryptor encryptor = new TextEncryptor(StaticVariable.authenticator_secret());
        String pass = encryptor.encrypt(text);
        this.password = pass;
    }
    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public StaticVariable.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(StaticVariable.accountType accountType) {
        this.accountType = accountType;
    }
}
