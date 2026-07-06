public class DependencyInjection {

    interface CustomerRepository {
        String findCustomerById(int id);
    }
    static class CustomerRepositoryImpl implements CustomerRepository {

        @Override
        public String findCustomerById(int id) {
            return "Customer ID: " + id + ", Name: Rahul Sharma";
        }
    }

    static class CustomerService {

        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void getCustomer(int id) {
            String customer = repository.findCustomerById(id);
            System.out.println(customer);
        }
    }

    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.getCustomer(101);
    }
}
