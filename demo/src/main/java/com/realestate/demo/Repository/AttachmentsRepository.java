package com.realestate.demo.Repository;

import com.realestate.demo.Entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentsRepository extends JpaRepository<Attachment, Integer> {
}
