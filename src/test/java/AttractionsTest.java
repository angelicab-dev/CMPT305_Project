import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttractionsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void readData() {

        //Attraction result = new Attraction()
    }

    @Test
    void getTotalAttractions() throws IOException {
        List<Attraction> attractions = new ArrayList<>();
        Attractions test = new Attractions(attractions);
        test.readData();
        test.getTotalAttractions();


        assertEquals(56,  test.getTotalAttractions());
    }

    @Test
    void findByFacilityName() {
    //expected
        /*
        Address: 13315 Buena Vista Road And, 87 Ave NW, Edmonton, AB T5J 2R7
        Type:Attraction
         */
    }

    @Test
    void filterByAttractionType() {
        //expected:
        /*
        [Facility: Queen Elizabeth Outdoor Pool
        Address: 9170 Walterdale Hill NW, Edmonton, AB T6E 2V3
        Type:Pool, Facility: Mill Creek Outdoor Swimming Pool
        Address: 9555 84 Ave NW, Edmonton, AB T6S 1E4
        Type:Pool, Facility: Fred Broadstock Outdoor Swimming Pool
        Address: 15720 105 Ave NW, Edmonton, AB T5P 2Y6
        Type:Pool, Facility: Scona Pool
        Address: 10450 72 Avenue NW
        Type:Pool, Facility: Borden Park Outdoor Pool
        Address: 7615 Borden Park Rd NW, Edmonton, AB T5B 4W8
        Type:Pool, Facility: Oliver Outdoor Swimming Pool
        Address: 10315 119 St NW, Edmonton, AB T5K 1Z6
        Type:Pool]
         */
    }

    @Test
    void getAttractions() {
        //expected:
        /*
      [Facility: Telus World of Science Edmonton
Address:
Type:Attraction, Facility: Prince of Wales Armouries Heritage Centre
Address:
Type:Attraction, Facility: Valley Zoo
Address: 13315 Buena Vista Road And, 87 Ave NW, Edmonton, AB T5J 2R7
Type:Attraction, Facility: Kinsmen Twin Arenas
Address: 1979 111 St NW, Edmonton, AB T6J 7C6
Type:Arena, Facility: A.C.T. Aquatics and Recreation Centre
Address: 2909 113 Ave NW, Edmonton, AB T5W 4S1
Type:Recreation Centre, Facility: Queen Elizabeth Outdoor Pool
Address: 9170 Walterdale Hill NW, Edmonton, AB T6E 2V3
Type:Pool, Facility: Mill Woods Recreation Centre
Address: 7207 - 28 Avenue NW
Type:Recreation Centre, Facility: Crestwood Arena
Address: 9940 147 St NW, Edmonton, AB T5N 4A6
Type:Arena, Facility: Grand Trunk Fitness and Leisure Centre
Address: 13025 112 St NW, Edmonton, AB T5E 6E4
Type:Recreation Centre, Facility: Peter Hemingway Fitness and Leisure Centre
Address: 13808 111 Ave NW, Edmonton, AB T5M 2P2
Type:Recreation Centre, Facility: Russ Barnes Arena
Address: 6725 121 Ave NW, Edmonton, AB T5B 0Y7
Type:Arena, Facility: The Meadows Community Recreation Centre
Address: 2704 - 17 STREET NW
Type:Recreation Centre, Facility: Kinsmen Pitch & Putt
Address:
Type:Attraction, Facility: John Janzen Nature Centre
Address: 7000 143 St NW, Edmonton, AB T6H 4P3
Type:Attraction, Facility: Abbottsfield Recreation Centre
Address:
Type:Recreation Centre, Facility: Mill Creek Outdoor Swimming Pool
Address: 9555 84 Ave NW, Edmonton, AB T6S 1E4
Type:Pool, Facility: Hardisty Fitness and Leisure Centre
Address: 10535 65 St NW, Edmonton, AB T6A 3X7
Type:Recreation Centre, Facility: St. Francis Xavier Field House
Address: 9240 163 St NW, Edmonton, AB T5R 0A7
Type:Recreation Centre, Facility: The Orange Hub
Address: 10035 156 St NW, Edmonton, AB T5P 2P7
Type:Attraction, Facility: Donnan Arena
Address: 9105 80 Ave NW, Edmonton, AB T6C 0N9
Type:Arena, Facility: Kinsmen Sports Centre
Address: 9100 Walterdale Hill
Type:Recreation Centre, Facility: Kenilworth Arena
Address: 8313 68A St NW, Edmonton, AB T6B 1T3
Type:Arena, Facility: Fort Edmonton Park
Address:
Type:Attraction, Facility: Commonwealth Community Recreation Centre
Address: 11000 Stadium Road
Type:Recreation Centre, Facility: Fred Broadstock Outdoor Swimming Pool
Address: 15720 105 Ave NW, Edmonton, AB T5P 2Y6
Type:Pool, Facility: Oliver Arena
Address: 10335 119 St NW, Edmonton, AB T5K 1Z6
Type:Arena, Facility: Callingwood Recreation Centre
Address: 17740 69 Ave NW, Edmonton, AB T5T 6X3
Type:Recreation Centre, Facility: Londonderry Fitness and Leisure Centre
Address: 14528 66 St NW, Edmonton, AB T5C 3R7
Type:Recreation Centre, Facility: Michael Cameron Arena
Address: 10404 56 St, Edmonton, AB T6A 2J2
Type:Arena, Facility: O'Leary Fitness and Leisure Centre
Address: 8804 132 Ave NW, Edmonton, AB T5E 0X9
Type:Recreation Centre, Facility: Castle Downs Recreation Centre
Address: 11520 - 153 Avenue NW
Type:Recreation Centre, Facility: George S. Hughes South Side Arena
Address: 10525 72 Ave NW, Edmonton, AB T6E 0Z6
Type:Arena, Facility: Confederation Arena
Address: 11204 43 Ave NW, Edmonton, AB T6J 0X8
Type:Arena, Facility: John Walter Museum
Address: 9180 Walterdale Hill NW, Edmonton, AB T6E 2V3
Type:Attraction, Facility: Scona Pool
Address: 10450 72 Avenue NW
Type:Pool, Facility: Rundle Park Paddle Boat House
Address: Rundle Park
Type:Attraction, Facility: Borden Park Outdoor Pool
Address: 7615 Borden Park Rd NW, Edmonton, AB T5B 4W8
Type:Pool, Facility: Bill Hunter Arena
Address: 9200 163 St NW, Edmonton, AB T5R 0A7
Type:Arena, Facility: Clareview Recreation Centre
Address: 3804 139 Ave NW, Edmonton, AB T5Y 3G4
Type:Recreation Centre, Facility: Westwood Arena
Address: 12040 97 St NW, Edmonton, AB T5G 2C1
Type:Arena, Facility: Eastglen Leisure Centre
Address: 11410 68 St NW, Edmonton, AB T5B 1P1
Type:Recreation Centre, Facility: Confederation Leisure Centre
Address:
Type:Recreation Centre, Facility: City Arts Centre
Address: 10943 84 Avenue, Edmonton AB T6G 0V5
Type:Attraction, Facility: Londonderry Arena
Address: 14520 66 St, Edmonton, AB T5C 3C8
Type:Arena, Facility: Downtown Community Arena
Address: 10245 105 Avenue NW
Type:Arena, Facility: Jasper Place Annex
Address:
Type:Recreation Centre, Facility: Glengarry Arena
Address: 13340 85 St NW, Edmonton, AB T5E 2Z8
Type:Arena, Facility: Jasper Place Fitness and Leisure Centre
Address: 9200 163 St NW, Edmonton, AB T5R 0A7
Type:Recreation Centre, Facility: Muttart Conservatory
Address: 9626 96A St NW, Edmonton, AB T6C 4L8
Type:Attraction, Facility: Oliver Outdoor Swimming Pool
Address: 10315 119 St NW, Edmonton, AB T5K 1Z6
Type:Pool, Facility: Booster Juice Recreation Centre in Terwillegar
Address: 2051 Leger Road
Type:Recreation Centre, Facility: Coronation Arena
Address: 13500 112 Ave NW, Edmonton, AB T5M 2T8
Type:Arena, Facility: Commonwealth Stadium
Address: 11000 Stadium Rd NW, Edmonton, AB T5H 4E2
Type:Recreation Centre, Facility: Rundle Park Mini Golf
Address: Rundle Park
Type:Attraction, Facility: Tipton Arena
Address: 10828 80 Ave NW, Edmonton, AB T6E, Canada
Type:Arena, Facility: Bonnie Doon Leisure Centre
Address: 8648 81 St NW, Edmonton, AB T5H 3S1
Type:Recreation Centre]
        */
    }

}