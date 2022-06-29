package com.example.server.repository;

import com.example.server.entity.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {

}
