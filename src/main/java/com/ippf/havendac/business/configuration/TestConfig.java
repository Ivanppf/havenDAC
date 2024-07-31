package com.ippf.havendac.business.configuration;

import com.ippf.havendac.business.services.ConverterService;
import com.ippf.havendac.business.services.PropertyServiceImpl;
import com.ippf.havendac.business.services.RoomServiceImpl;
import com.ippf.havendac.business.services.UserServiceImpl;
import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.model.ENUM.RoomType;
import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.model.entities.Role;
import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.model.entities.User;
import com.ippf.havendac.model.repository.UserRepository;
import com.ippf.havendac.presentation.DTO.request.PropertyRequestDTO;
import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor
public class TestConfig implements CommandLineRunner {

    private final ConverterService converterService;
    private PropertyServiceImpl propertyService;
    private RoomServiceImpl roomService;
    private UserServiceImpl userService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        PropertyRequestDTO p1 = new PropertyRequestDTO(PropertyType.APARTMENT, true, false, true, "Spacious apartment in the city center with a swimming pool.");
        PropertyRequestDTO p2 = new PropertyRequestDTO(PropertyType.HOUSE, true, true, false, "Cozy countryside house perfect for a weekend getaway.");
        PropertyRequestDTO p3 = new PropertyRequestDTO(PropertyType.BEDROOM, false, false, false, "Comfortable bedroom in a shared apartment.");
        PropertyRequestDTO p4 = new PropertyRequestDTO(PropertyType.CABIN, true, true, false, "Rustic cabin nestled in the woods, ideal for nature lovers.");
        PropertyRequestDTO p5 = new PropertyRequestDTO(PropertyType.BED_N_BREAKFASTS, true, true, true, "Quaint bed and breakfast with a swimming pool, perfect for a relaxing stay.");
        PropertyRequestDTO p6 = new PropertyRequestDTO(PropertyType.FARM, false, true, false, "Charming farm with scenic views, currently unavailable for bookings.");
        PropertyRequestDTO p7 = new PropertyRequestDTO(PropertyType.APARTMENT, true, false, false, "Modern apartment in a bustling urban area.");
        PropertyRequestDTO p8 = new PropertyRequestDTO(PropertyType.HOUSE, true, true, true, "Spacious countryside house with a private swimming pool.");
        PropertyRequestDTO p9 = new PropertyRequestDTO(PropertyType.BEDROOM, true, false, false, "Cozy bedroom in a quiet residential neighborhood.");
        PropertyRequestDTO p10 = new PropertyRequestDTO(PropertyType.FARM, true, true, true, "Working farm offering accommodations and farm experiences.");

        List<Property> plist = List.of(
                new Property(p1),
                new Property(p2),
                new Property(p3),
                new Property(p4),
                new Property(p5),
                new Property(p6),
                new Property(p7),
                new Property(p8),
                new Property(p9),
                new Property(p10)
        );

        propertyService.saveAll(plist);

        RoomRequestDTO r1 = new RoomRequestDTO(5f, 4f, RoomType.BEDROOM, 1);
        RoomRequestDTO r2 = new RoomRequestDTO(3f, 3f, RoomType.BATHROOM, 1);
        RoomRequestDTO r3 = new RoomRequestDTO(6f, 5f, RoomType.KITCHEN, 2);
        RoomRequestDTO r4 = new RoomRequestDTO(4f, 4f, RoomType.LIVING_ROOM, 3);
        RoomRequestDTO r5 = new RoomRequestDTO(3f, 3f, RoomType.BEDROOM, 4);
        RoomRequestDTO r6 = new RoomRequestDTO(5f, 4f, RoomType.DINING_ROOM, 4);
        RoomRequestDTO r7 = new RoomRequestDTO(4f, 3f, RoomType.LAUNDRY, 5);
        RoomRequestDTO r8 = new RoomRequestDTO(6f, 6f, RoomType.BEDROOM, 6);
        RoomRequestDTO r9 = new RoomRequestDTO(4f, 4f, RoomType.BATHROOM, 6);
        RoomRequestDTO r10 = new RoomRequestDTO(5f, 3f, RoomType.KITCHEN, 7);

        List<RoomRequestDTO> rlist = List.of(
                r1,
                r2,
                r3,
                r4,
                r5,
                r6,
                r7,
                r8,
                r9,
                r10
        );

        List<Room> roomList = new ArrayList<>();
        rlist.forEach(r -> {
            Room room = converterService.dtoToRoom(r);
            roomList.add(room);
        });
        roomService.saveAll(roomList);

        User user1 = new User();
        user1.setName("Rhaenyra Targaryen");
        user1.setNickname("rhaenyra");
        user1.setEmail("rhaenyra@gmail.com");
        user1.setPassword(passwordEncoder.encode("rhaenyra123"));
        user1.setRoles((List.of(Role.ADMIN)));

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Daemon Targaryen");
        user2.setNickname("daemon");
        user2.setEmail("daemon@gmail.com");
        user2.setPassword("daemon123");

        User user3 = new User();
        user3.setName("Viserys I Targaryen");
        user3.setNickname("viserys");
        user3.setEmail("viserys@gmail.com");
        user3.setPassword("viserys123");

        User user4 = new User();
        user4.setName("Alicent Hightower");
        user4.setNickname("alicent");
        user4.setEmail("alicent@gmail.com");
        user4.setPassword("alicent123");

        User user5 = new User();
        user5.setName("Otto Hightower");
        user5.setNickname("otto");
        user5.setEmail("otto@gmail.com");
        user5.setPassword("otto123");

        User user6 = new User();
        user6.setName("Corlys Velaryon");
        user6.setNickname("corlys");
        user6.setEmail("corlys@gmail.com");
        user6.setPassword("corlys123");

        User user7 = new User();
        user7.setName("Rhaenys Targaryen");
        user7.setNickname("rhaenys");
        user7.setEmail("rhaenys@gmail.com");
        user7.setPassword("rhaenys123");

        User user8 = new User();
        user8.setName("Laenor Velaryon");
        user8.setNickname("laenor");
        user8.setEmail("laenor@gmail.com");
        user8.setPassword("laenor123");

        User user9 = new User();
        user9.setName("Aemond Targaryen");
        user9.setNickname("aemond");
        user9.setEmail("aemond@gmail.com");
        user9.setPassword("aemond123");

        User user10 = new User();
        user10.setName("Aegon II Targaryen");
        user10.setNickname("aegon");
        user10.setEmail("aegon@gmail.com");
        user10.setPassword("aegon123");


        try {
            List<User> users = List.of(user2, user3, user4, user5, user6, user7, user8, user9, user10);
            users.forEach((user) -> {
                userService.save(user);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
