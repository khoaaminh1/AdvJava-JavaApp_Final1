# 💰 Personal Finance Tracker

A modern, responsive web application for tracking personal finances built with Spring Boot and Thymeleaf.

## 📋 Features

- **Dashboard Overview**: Visual summary of income, expenses, and net balance
- **Transaction Management**: Add, view, and track all financial transactions
- **Budget Planning**: Set monthly budgets by category and monitor spending
- **Category System**: Organize transactions with customizable categories
- **Account Management**: Manage multiple accounts (Cash, Bank, E-Wallet, Credit Card)
- **Interactive Charts**: Visualize spending patterns with Chart.js
- **Responsive Design**: Works seamlessly on desktop, tablet, and mobile devices

## 🚀 Technologies Used

- **Backend**: Spring Boot 3.3.3, Java 17
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Charts**: Chart.js
- **Icons**: RemixIcon
- **Build Tool**: Maven
- **Development**: Spring Boot DevTools for hot reload

## 📁 Project Structure

```
Demo_UI_AdvJava/
├── src/
│   ├── main/
│   │   ├── java/com/example/pftui/
│   │   │   ├── PftUiApplication.java           # Main application class
│   │   │   ├── controller/                     # Controllers for handling requests
│   │   │   │   ├── DashboardController.java
│   │   │   │   ├── TransactionController.java
│   │   │   │   ├── BudgetController.java
│   │   │   │   ├── CategoryController.java
│   │   │   │   └── AccountController.java
│   │   │   ├── model/                          # Data models
│   │   │   │   ├── Transaction.java
│   │   │   │   ├── Budget.java
│   │   │   │   ├── Category.java
│   │   │   │   ├── Account.java
│   │   │   │   └── DashboardVM.java
│   │   │   └── service/                        # Business logic
│   │   │       └── FakeDataService.java
│   │   └── resources/
│   │       ├── application.properties          # App configuration
│   │       ├── static/
│   │       │   ├── css/
│   │       │   │   └── app.css                # Main stylesheet
│   │       │   └── js/
│   │       │       └── app.js                 # JavaScript functions
│   │       └── templates/                      # Thymeleaf templates
│   │           ├── dashboard.html
│   │           ├── transactions.html
│   │           ├── budgets.html
│   │           ├── categories.html
│   │           ├── accounts.html
│   │           └── fragments/                  # Reusable components
│   │               ├── head.html
│   │               ├── sidebar.html
│   │               └── scripts.html
│   └── test/                                   # Unit tests
├── pom.xml                                     # Maven dependencies
└── README.md
```

## 🎨 UI/UX Design Highlights

### Color Scheme
- **Primary**: Indigo (#6366f1) - Modern and professional
- **Success**: Green (#10b981) - Income and positive actions
- **Danger**: Red (#ef4444) - Expenses and alerts
- **Neutral**: Slate grays - Clean, minimal background

### Design Features
- ✨ **Modern Card-Based Layout**: Clean, organized interface
- 🎯 **Intuitive Navigation**: Fixed sidebar with clear icons
- 📊 **Interactive Charts**: Doughnut and line charts for data visualization
- 🎨 **Consistent Styling**: Unified design language across all pages
- 📱 **Responsive Design**: Adapts to all screen sizes
- ⚡ **Smooth Animations**: Subtle hover effects and transitions
- 🌈 **Color-Coded Data**: Easy to distinguish income vs expense

## 🛠️ Setup & Installation

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Running the Application

1. **Clone the repository** (if applicable)
   ```bash
   git clone <repository-url>
   cd Demo_UI_AdvJava
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```
   Or on Windows:
   ```bash
   mvnw.cmd clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or on Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```

4. **Access the application**
   Open your browser and navigate to: `http://localhost:8080`

## 📖 Usage Guide

### Dashboard
- View your monthly income, expenses, and net balance at a glance
- Analyze spending by category with interactive pie chart
- Track cash flow trends over the last 6 months
- See recent transactions and budget status

### Transactions
- Add new transactions with date, merchant, amount, category, and account
- View all transactions in an organized table
- Track both income and expenses

### Budgets
- Set monthly budgets for different spending categories
- Monitor budget usage with visual progress bars
- Get alerts when approaching budget limits
- View all budgets across different months

### Categories
- Create custom categories for income and expenses
- Assign icons to categories for easy identification
- Organize transactions effectively

### Accounts
- Manage multiple accounts (Cash, Bank, E-Wallet, Credit Card)
- Track balance across different account types
- Support for multiple currencies

## 🎯 Best Practices Implemented

### Code Structure
✅ **MVC Pattern**: Clear separation of concerns (Model-View-Controller)
✅ **Service Layer**: Business logic isolated in service classes
✅ **Reusable Components**: Thymeleaf fragments for common UI elements
✅ **Consistent Naming**: Following Java and Spring Boot conventions

### UI/UX
✅ **Accessibility**: Semantic HTML, proper labels, keyboard navigation
✅ **User Feedback**: Form validation, visual feedback on actions
✅ **Consistency**: Unified design language and components
✅ **Performance**: Optimized assets, minimal dependencies

### Development
✅ **Hot Reload**: Spring DevTools for rapid development
✅ **Clean Code**: Well-organized, commented code
✅ **Version Control Ready**: Proper .gitignore (if needed)

## 🔮 Future Enhancements

- [ ] User authentication and authorization
- [ ] Database integration (H2, PostgreSQL, MySQL)
- [ ] Export data to CSV/PDF
- [ ] Recurring transactions
- [ ] Advanced filtering and search
- [ ] Multi-currency support
- [ ] Mobile app version
- [ ] Email notifications for budget alerts
- [ ] Data backup and restore

## 📝 Configuration

Application settings can be modified in `src/main/resources/application.properties`:

```properties
# Server Port
server.port=8080

# Application Name
spring.application.name=Personal Finance Tracker

# Thymeleaf Configuration
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

## 📄 License

This project is open source and available under the MIT License.

## 👨‍💻 Author

[TRAN MINH KHOA -Fontend]
[PHAM MANH HOA - Fotend]
[TRAN QUANG VINH - Backend]

## 🙏 Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Chart.js](https://www.chartjs.org/)
- [RemixIcon](https://remixicon.com/)
- [Inter Font](https://fonts.google.com/specimen/Inter)

---

⭐ **Happy Financial Tracking!** ⭐
