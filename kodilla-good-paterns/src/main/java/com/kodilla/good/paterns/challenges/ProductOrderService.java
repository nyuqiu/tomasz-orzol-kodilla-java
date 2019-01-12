package com.kodilla.good.paterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private BuyingService buyingService;
    private BuyingRepository buyingRepository;

    public ProductOrderService(final InformationService informationService,
                               final BuyingService buyingService,
                               final BuyingRepository buyingRepository) {
        this.informationService = informationService;
        this.buyingService = buyingService;
        this.buyingRepository = buyingRepository;
    }

    public BuyingDto process(final BuyingRequest buyingRequest) {
        boolean isBought = buyingService.buy(buyingRequest.getUser(), buyingRequest.getProduct(),
                buyingRequest.getAddress());

        if (isBought) {
            informationService.inform(buyingRequest.getUser());
            buyingRepository.createOrder(buyingRequest.getUser(), buyingRequest.getProduct(), buyingRequest.getAddress());
            return new BuyingDto(buyingRequest.getUser(), true);
        } else {
            return new BuyingDto(buyingRequest.getUser(), false);
        }
    }

}

class Application {
    public static void main(String[] args){
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyingRequest buyingRequest = buyRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new EmailService(), new ProductBuyingService(), new ProductBuyingRepository());
        productOrderService.process(buyingRequest);
    }
}

class BuyingRequest {

    private User user;
    private String product;
    private String address;

    public BuyingRequest(final User user, final String product, final String address) {
        this.user = user;
        this.product = product;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }

    public String getAddress() {
        return address;
    }
}

interface InformationService {

    void inform(User user);

}

class EmailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Order has been created for "+user.getName()+user.getSurname());
    }
}

interface BuyingService {

    boolean buy(User user, String product, String address);

}

class ProductBuyingService implements BuyingService{

    @Override
    public boolean buy(User user, String product, String address) {
        if(product!=null && address!=null) {
            System.out.println("Creating order for "+ user.getName()+user.getSurname()+" with product "+product+ ", for address "+address);
            return true;
        } else {
            System.out.println("Product not avaiable/Address not correct");
            return false;
        }
    }
}

interface BuyingRepository {

    boolean createOrder(User user, String product, String address);

}

class ProductBuyingRepository implements BuyingRepository {

    @Override
    public boolean createOrder(User user, String product, String address) {
        System.out.println("Order for "+ user.getName()+user.getSurname()+" has been saved");
        return true;
    }
}

class BuyingDto {

    private User user;
    private boolean isBought;

    public BuyingDto(final User user, final boolean isBought) {
        this.user = user;
        this.isBought = isBought;
    }

    public User getUser() {
        return user;
    }

    public boolean isBought() {
        return isBought;
    }
}

class User {

    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
class BuyRequestRetriever{

    public BuyingRequest retrieve(){

        User user = new User("John", "Wekl");

        String product = "Yellow Duck";

        String address = "Bristol";

        return new BuyingRequest(user, product, address);

    }
}
