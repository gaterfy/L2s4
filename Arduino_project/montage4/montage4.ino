/*
 * Montage 4
 */
#define NB_LED 3
const int greenLedPin=9;
const int redLedPin=11;
const int blueLedPin=10;
const int led[3]={redLedPin,greenLedPin,blueLedPin};

/*port analogique */
const int redSensorPin=A0;
const int greenSensorPin=A1;
const int blueSensorPin=A2;

/*valeurs colors */
int redValue=0;
int greenValue=0;
int blueValue=0;

int redSensorValue=0;
int greenSensorValue=0;
int blueSensorValue=0;
void setup()
{
  Serial.begin(9600);
  for(int cpt=0;cpt<NB_LED;cpt++){
    pinMode(led[cpt],OUTPUT);
   }
  
  }

void loop(){
  /*lire les les entrées analogiques*/
  redSensorValue=analogRead(redSensorPin);
  delay(5);
  greenSensorValue= analogRead(greenLedPin);
  delay(5);
  blueSensorValue= analogRead(blueSensorPin);
  delay(5);
  Serial.print("Raw Sensor Values \t Red :");
  delay(1000);
  Serial.print(redSensorValue);
  //delay(1000);
  Serial.print(" \t Green :");
  Serial.print(greenSensorValue);
  //delay(1000);
  Serial.print(" \t Blue :");
  Serial.print(blueSensorValue);
  
  redValue=redSensorValue/4;
  greenValue=greenSensorValue/4;
  blueValue=blueSensorValue/4;
  
  Serial.print("Valeurs Recalculees \t Rouge :");
  Serial.print(redValue);
  Serial.print("\t vert : ");
  Serial.print(greenValue);
  Serial.print("\t bleu : ");
  Serial.print(blueValue);
  int Value[NB_LED]={redValue,greenValue,blueValue};/*on stocke les values dans un tableau*/
  for(int cpt=0;cpt<NB_LED;cpt++){
    analogWrite(led[cpt],Value[cpt]);
   }
  }
