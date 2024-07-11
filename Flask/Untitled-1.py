from flask import Flask, request, jsonify
import requests

app = Flask(__name__)

@app.route('/')
def home():
    return "Hello, Flask!"

@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return "No file part", 400
    
    file = request.files['file']
    
    if file.filename == '':
        return "No selected file", 400
    
    if file:
        # Process the file
        file_content = file.read().decode('utf-8')
        word_count = len(file_content.split())
        letter_count = len(file_content.replace(" ", ""))
        
        processed_data = {
            "filename": file.filename,
            "wordCount": word_count,
            "letterCount": letter_count
        }
        
        # Send processed data to Spring Boot
        response = requests.post('http://localhost:8080/api/saveCounts', json=[processed_data])
        if response.status_code == 200:
            return jsonify({"message": "File processed and data sent to Spring Boot", "data": processed_data})
        else:
            return jsonify({"message": "Failed to send data to Spring Boot"}), 500

if __name__ == '__main__':
    app.run(port=5000, debug=True)
