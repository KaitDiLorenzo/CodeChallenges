def get_name_score(name):
    name_score = 0

    for character in name:
        name_score += ord(character) - 64

    return name_score

def get_sorted_names(file_name):
    names = []
    with open(file_name) as f:
        for line in f.readlines():
            for name in line.split(','):
                name = name.replace('"', '')
                
                i = 0
                while i < len(names) and names[i] < name:
                    i += 1
                
                if i == len(names):
                    names.append(name)
                else:
                    names.insert(i, name)

    return names

def name_scores(file_name):
    name_scores_sum = 0
    names = get_sorted_names(file_name)
    
    for i in range(0, len(names)):
        name_scores_sum += get_name_score(names[i]) * (i + 1)

    return name_scores_sum
                

print(name_scores("project-euler/name_scores/names.txt"))