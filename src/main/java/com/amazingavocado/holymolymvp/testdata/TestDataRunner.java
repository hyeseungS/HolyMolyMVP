package com.amazingavocado.holymolymvp.testdata;

import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.Shop;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.ItemRepository;
import com.amazingavocado.holymolymvp.repository.ShopRepository;
import com.amazingavocado.holymolymvp.repository.UserRepository;
import com.amazingavocado.holymolymvp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class TestDataRunner implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 테스트 User 생성
        User testUser1 = new User(1L, 20, 1, "경기");

        testUser1 = userRepository.save(testUser1);

        // Shop 등록
        Shop testShop1 = new Shop(1L, "가나다란", "서울특별시 강남구 논현동 봉은사로 123 리체 힐 604호", "", "", "");
        Shop testShop2 = new Shop(2L, "Amor", "경기 시흥시 서울대학로 210", "", "", "");
        shopRepository.save(testShop1);
        shopRepository.save(testShop2);

        // Item 등록
        Item testItem1 = new Item(1L, testShop1, "붉은 튤립 10송이 다발1", 40000, 50000, "꽃 설명", "red", "데이트 생일 기념일", "");
        Item testItem2 = new Item(2L, testShop1, "프리지아 하늘색 꽃다발1", 40000, 50000, "꽃 설명", "blue", "데이트 부모님 선물 기념일", "");
        Item testItem3 = new Item(3L, testShop1, "붉은 튤립 10송이 다발2", 40000, 50000, "꽃 설명", "red", "데이트 개업축하 기념일", "");
        Item testItem4 = new Item(4L, testShop1, "프리지아 하늘색 꽃다발2", 70000, 80000, "꽃 설명", "red", "데이트 공식적 상황 기념일", "");
        Item testItem5 = new Item(5L, testShop1, "붉은 튤립 10송이 다발3", 40000, 50000, "꽃 설명", "red", "데이트 시상식 기념일", "");
        Item testItem6 = new Item(6L, testShop2, "프리지아 하늘색 꽃다발3", 40000, 50000, "꽃 설명", "red", "공연", "");
        Item testItem7 = new Item(7L, testShop1, "붉은 튤립 10송이 다발4", 40000, 50000, "꽃 설명", "red", "데이트 결혼식 기념일", "");
        Item testItem8 = new Item(8L, testShop2, "붉은 튤립 10송이 다발5", 40000, 50000, "꽃 설명", "red", "데이트 결혼식 기념일", "");
        Item testItem9 = new Item(9L, testShop1, "붉은 튤립 10송이 다발6", 40000, 50000, "꽃 설명", "red", "데이트 부모님 선물 기념일", "");
        Item testItem10 = new Item(10L, testShop2, "붉은 튤립 10송이 다발7", 40000, 50000, "꽃 설명", "red", "데이트 개업 축하 기념일", "");
        itemRepository.save(testItem1); itemRepository.save(testItem2);
        itemRepository.save(testItem3); itemRepository.save(testItem4);
        itemRepository.save(testItem5); itemRepository.save(testItem6);
        itemRepository.save(testItem7); itemRepository.save(testItem8);
        itemRepository.save(testItem9); itemRepository.save(testItem10);


    }


}
