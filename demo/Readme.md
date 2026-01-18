For profiling
1. Start your application with the desired profile, e.g., `--spring.profiles.active=dev`
2. this leads editing of the code, so the other way is to set profile using this command :
`mvn spring-boot:run -Dspring-boot.run.profiles=dev`
3. either add a profile in pom.xml 
`<profiles>
		<profile>
			<id>local</id>
			<spring-boot.run.profiles>dev</spring-boot.run.profiles>
		</profile>
		<profile>
			<id>production</id>
			<spring-boot.run.profiles>prod</spring-boot.run.profiles>
		</profile>
		<profile>
			<id>test</id>
			<spring-boot.run.profiles>uat</spring-boot.run.profiles>
		</profile>
</profiles>`
mvn spring-boot:run -Pspring-boot.run.profiles=dev