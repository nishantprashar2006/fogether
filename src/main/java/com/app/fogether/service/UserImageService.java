package com.app.fogether.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.fogether.domain.UserImage;
import com.app.fogether.repository.UserImageRepository;
import com.app.fogether.utilities.AmazonClient;

@Service
public class UserImageService {

	@Autowired
	private SequenceGeneratorService sgs;
	
	@Autowired
	private AmazonClient amazonClient;
	
	@Autowired
	private UserImageRepository usersImageRepo;
	
	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	
	public String uploadFile(MultipartFile multipartFile, Long userId, String description) {
		String imageLocation = "";
		try {
			Long imageId = generateImageId();
			Long uploadTime = new Date().getTime();
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile, userId, imageId, uploadTime);
			imageLocation = endpointUrl + "/" + fileName;
			amazonClient.uploadFileTos3bucket(fileName, file);
			file.delete();
			insertImage(imageId, uploadTime, imageLocation, description, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageLocation;
	}

	public Long generateImageId() {
		Long imageId = sgs.generateSequence(UserImage.SEQUENCE_NAME);
		return imageId;
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	private String generateFileName(MultipartFile multiPart, Long userId, Long imageId, Long uploadTime) {
		return uploadTime + "_" + "userId-" + userId + "_" + "imageId-" + imageId + "_"
				+ multiPart.getOriginalFilename().replace(" ", "_");
	}
	
	public void insertImage(Long imageId, Long uploadTime, String imageLocation, String description, Long userId)
			throws AddressException, MessagingException, IOException {
		UserImage usersImage = new UserImage(imageId, uploadTime, imageLocation, description, userId);
		usersImageRepo.save(usersImage);
	}

}
