#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define MAX_NAME 50
#define MAX_NATIONALITY 30
#define MAXTAB 1000
#define MAXLINE 500

enum field {
  Literature,
  Physics,
  Chemistry,
  Peace,
  PhysiologyOrMedicine
};

enum gender {
  male,
  female
};

struct birthday {
  int year;
  int month;
  int day;
};

struct Nomine_s {
  int prize_date;
  enum field field_nominee;
  char nominee[MAX_NAME];
  struct birthday birthday_nominee;
  char nationality[MAX_NATIONALITY];
  enum gender gender_nominee;
};

int CompareNomineParAgeDObtention(struct Nomine_s * nominee1,struct Nomine_s * nominee2) {
  if (nominee1->prize_date == nominee2->prize_date)
    return 0;
  else
    return nominee1->prize_date>nominee2->prize_date?1:-1;
}

/**
  Construct the array of all the nominees given in the file nobel.txt

  @param nominees all the nominees
  FUNCTION NOT FINISHED YET
*/
int ConstruireTableaux(struct Nomine_s * nominees)
{
  FILE* file = fopen("nobel.txt", "r");
  int n_nom = 0;
  char line[MAXLINE];
  if (file != NULL) {
    while (fgets(line, MAXLINE, file)) {
      /* Prize year */
      int prize_year = 0;
      int i;
      for (i=0; i<4; i++) {
  	prize_year = prize_year*10 + (line[i] - '0');
      }
      nominees[n_nom].prize_date = prize_year;
      /* Field of study */
      i = 6;
      char field = line[i];
      while (line[i]!='"') i++;
      if (field=='L')
  	nominees[n_nom].field_nominee = Literature;
      else if (field == 'C')
        nominees[n_nom].field_nominee = Chemistry;
      else {
  	if (field == 'P' && field == 'e')
  	  nominees[n_nom].field_nominee = Peace;
  	else {
  	  if (field=='s')
  	    nominees[n_nom].field_nominee = Physics;
  	  else
  	    nominees[n_nom].field_nominee = PhysiologyOrMedicine;
  	}
      }
      /* Nominee name */
      i=i+3;
      int j = 0;
      while (line[i]!='"')
  	nominees[n_nom].nominee[j++] = line[i++];
      nominees[n_nom].nominee[j] = '\0';
      /* Nominee date of birth */
      nominees[n_nom].birthday_nominee.year = 0;
      nominees[n_nom].birthday_nominee.month = 0;
      nominees[n_nom].birthday_nominee.day = 0;
      i=i+3;
      j=0;
      while (line[i]!='-')
  	nominees[n_nom].birthday_nominee.year = nominees[n_nom].birthday_nominee.year*10 + (line[i++] - '0');
      i++;
      while (line[i]!='-')
        nominees[n_nom].birthday_nominee.month = nominees[n_nom].birthday_nominee.month*10 + (line[i++] - '0');
      i++;
      while (line[i]!='"')
  	nominees[n_nom].birthday_nominee.day = nominees[n_nom].birthday_nominee.day*10 + (line[i++] - '0');
      /* Transition */
      i++;
      while (line[i++]!='"');
      /* Nominee Nationality */
      j=0;
      while (line[i]!='"')
        nominees[n_nom].nationality[j++] = line[i++];
      nominees[n_nom].nationality[j]='\0';
      /* Nominee gender */
      i=i+3;
      if (line[i]=='m')
  	nominees[n_nom].gender_nominee = male;
      else
        nominees[n_nom].gender_nominee = female;
      n_nom++;
    }
  } else {
    printf("Failed to open nobel.txt");
  }
  return n_nom;
}

/**
  Main function
*/
int main(void)
{
  struct Nomine_s nominees[MAXTAB];
  int n_nom = ConstruireTableaux(nominees);
  int i;
  for (i=0; i<10; i++)
    printf("%s,born the %d-%d-%d of %d gender in %s , won a %d prize in %d\n",
	   nominees[i].nominee,
	   nominees[i].birthday_nominee.year,
	   nominees[i].birthday_nominee.month,
	   nominees[i].birthday_nominee.day,
	   nominees[i].gender_nominee,
	   nominees[i].nationality,
	   nominees[i].field_nominee,
	   nominees[i].prize_date);
  printf("Comparaison:%d\n",CompareNomineParAgeDObtention(&nominees[9],&nominees[0]));
}
