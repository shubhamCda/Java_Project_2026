Logic to build Ticket Booking App
Building IRCTC form of APP
1. Able to login / signup
2. Fetch / Search trains A --> B
3. Shows available seats


LLD:
1. Entities
    i. User
        :name
        :hashed-password(encrypt)
        :history
        :userid(UUID)
    ii. Ticket
        :ticket id (String)
        :userID (String)
        :source (String)
        :destination (String)
        :date-time
    iii. Train
        :trainID
        :TrainNo
        :Arrival time
        :Departure time
        :Available seats (List<boolean> seats)
2. Service
    i. Booking
        :login User (User user)
        :signup
        :fetch booking
        :cancel booking
    ii. Train
        :book ticket (String a, String b)
        :available seats