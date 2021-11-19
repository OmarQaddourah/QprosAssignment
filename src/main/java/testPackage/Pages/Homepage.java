package testPackage.Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter
@Setter
public class Homepage {

  public Homepage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(className = "img-responsive")
  private WebElement petImage;

  @FindBy(xpath = "//span[text()='Veterinarians']")
  private WebElement veterinariansTab;

  @FindBy(id = "vets")
  private WebElement veterinariansList;

  @FindBy(xpath = "//a[@title='find owners']")
  private WebElement findOwnersTab;

  @FindBy(css = ":nth-child(2) > div button")
  private WebElement findOwnerButton;

  @FindBy(css = "#owners tbody")
  private WebElement ownersList;

  @FindBy(xpath = "//a[@href='/owners/new']")
  private WebElement addNewOwnerButton;

  @FindBy(css = "input#firstName")
  private WebElement firstNameField;

  @FindBy(css = "input#lastName")
  private WebElement lastNameField;

  @FindBy(css = "input#address")
  private WebElement addressField;

  @FindBy(css = "input#city")
  private WebElement cityField;

  @FindBy(css = "input#telephone")
  private WebElement telephoneField;

  @FindBy(xpath = "//button[text()='Add Owner']")
  private WebElement addOwnerButton;

  @FindBy(xpath = "//a[@href='11/pets/new']")
  private WebElement addNewPetButton;

  @FindBy(css = "input#name")
  private WebElement petNameField;

  @FindBy(css = "input#birthDate")
  private WebElement birthDateField;

  @FindBy(css = "select#type")
  private WebElement typeDropdown;

  @FindBy(xpath = "//button[text()='Add Pet']")
  private WebElement addPetButton;

  @FindBy(xpath = "//h2[text()='Pets and Visits']")
  private WebElement petsSection;

  public void clickOnVeterinariansTab() {
    this.veterinariansTab.click();
  }

  public void clickOnFindOwnersTab() {
    this.findOwnersTab.click();
  }

  public void clickOnFindOwnerButton() {
    this.findOwnerButton.click();
  }

  public void addNewOwnerAndPet(
      String firstName,
      String lastName,
      String address,
      String city,
      String telephone,
      String petName,
      String birthDate) {
    this.findOwnersTab.click();
    this.addNewOwnerButton.click();
    this.firstNameField.sendKeys(firstName);
    this.lastNameField.sendKeys(lastName);
    this.addressField.sendKeys(address);
    this.cityField.sendKeys(city);
    this.telephoneField.sendKeys(telephone);
    this.addOwnerButton.click();
    this.addNewPetButton.click();
    this.petNameField.sendKeys(petName);
    this.birthDateField.sendKeys(birthDate);
    this.typeDropdown.click();
    Select typeOfPet = new Select(this.typeDropdown);
    typeOfPet.selectByVisibleText("cat");
    this.addPetButton.click();
  }
}
