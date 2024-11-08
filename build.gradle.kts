plugins {
	java
	`java-library`
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	`maven-publish`
}

group = "ru.zmaev"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

publishing {
	publications {
		create<MavenPublication>("gpr") {
			from(components["java"])
			groupId = groupId
			artifactId = artifactId
			version = project.findProperty("gpr.version") as String? ?: System.getenv("VERSION")
		}
	}
	repositories {
		maven {
			name = "GitHubPackages"
			url = uri("https://maven.pkg.github.com/ZmaevDA/common-lib")
			credentials {
				username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
				password = project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN")
			}
		}
	}
}

repositories {
	mavenCentral()
}


dependencies {
	api("org.projectlombok:lombok:1.18.24")
	api("org.springframework.boot:spring-boot-autoconfigure")

	testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.8.1")

	api("org.springframework.boot:spring-boot-starter:3.3.1")
	api("org.springframework.boot:spring-boot-starter-security:3.2.5")
	api("com.auth0:java-jwt:4.3.0")

	api("org.springframework.data:spring-data-elasticsearch:4.0.0.RELEASE")
	api("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.17.22")

	api("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	api("org.springframework.boot:spring-boot-starter-oauth2-client:3.2.5")
	api("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.2.5")

	api("jakarta.servlet:jakarta.servlet-api:6.1.0")

	api("com.squareup.retrofit2:retrofit:2.9.0")
	api("com.squareup.retrofit2:converter-jackson:2.9.0")
	api("com.squareup.retrofit2:converter-gson:2.9.0")

	api("com.squareup.okhttp3:okhttp:4.9.0")

	api("org.keycloak:keycloak-admin-client:20.0.2")

	api("org.springframework.amqp:spring-rabbit:3.1.5")

	api("io.minio:minio:8.5.10")

	api("org.springframework.boot:spring-boot-starter-mail")

	annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
