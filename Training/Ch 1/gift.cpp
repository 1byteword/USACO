#include <vector>
#include <fstream>
#include <map>
using namespace std;

#define F0R(i, a) for(int i = 0; i < a; i++)

map<string, int> names;
int main()
{
	ifstream cin("gift.in");
	ofstream cout("gift.out");
	int T; cin >> T;
	string *array = new string[T];
	F0R(i, T){
		string s; cin >> s;
		names[s] = 0;
		array[i] = s;
	}
	
	F0R(i, T){
		string giver; cin >> giver;
		int am, many; cin >> am >> many;
		F0R(i, T)
		{
			string rec = ""; cin >> rec;
			names[giver] += am/many;
		}
		names[giver] -= am%many;
	}
	F0R(i, T)
	{
		cout << array[i] << " " << names[array[i]] << endl;
	}
}
